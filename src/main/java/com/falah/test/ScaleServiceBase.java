/*
 * Copyright (c) 2011, Kustaa Nyholm / SpareTimeLabs
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution.
 *
 * Neither the name of the Kustaa Nyholm or SpareTimeLabs nor the names of its
 * contributors may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 */
package com.falah.test;

import com.falah.test.core.WeightListener;
import purejavacomm.CommPortIdentifier;
import purejavacomm.NoSuchPortException;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ScaleServiceBase {

    public static final String APPLICATION_NAME = "PureJavaCommTestSuite";

    protected static volatile String m_TestPortName;
    protected static volatile SerialPort m_Port;
    private static volatile long m_T0;
    protected static volatile OutputStream m_Out;
    protected static volatile InputStream m_In;
    protected static int m_Tab;
    protected static int m_Progress;

    static protected void openPort(WeightListener weightListener) {
        try {
            CommPortIdentifier portid = CommPortIdentifier.getPortIdentifier(m_TestPortName);
            m_Port = (SerialPort) portid.open(APPLICATION_NAME, 1000);
            m_Out = m_Port.getOutputStream();
            m_In = m_Port.getInputStream();
            drain(m_In, weightListener);
        } catch (NoSuchPortException | PortInUseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static protected void closePort() {
        if (m_Port != null) {
            try {
                m_Out.flush();
                m_Port.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                m_Port = null;
            }
        }
    }

    static String[] loading = new String[]{"|", "/", "-", "\\"};
    static int loadingIndex = 0;

    static protected void drain(InputStream ins, WeightListener weightListener) {
        try {
            sleep(100);
            int n;
            var weights = new ArrayList<Double>();
            while (true) {
                n = ins.available();
                var buf = new byte[n];
                ins.read(buf);
                var s = new String(buf);
                if (s.isEmpty()) continue;
                var weightPattern = Pattern.compile("(\\d+\\.\\d+)(kg)");
                var weight = 0.0;
                var unit = "";
                var matcher = weightPattern.matcher(s);
                System.out.print("\b" + loading[loadingIndex++]);
                if (loadingIndex == loading.length) loadingIndex = 0;
                if (matcher.find()) {
                    weight = Double.parseDouble(matcher.group(1));
                    unit = matcher.group(2);
                    if ((int) weight > 0) {
                        System.out.println("Weight: " + weight + " " + unit);
                        weights.add(weight);
                        if (weights.size() > 10) {
                            weightListener.weightChanged(
                                    weights.stream().max(Double::compare).get()
                            );
                            weights.clear();
                            break;
                        }
                    }
                }
            }
            System.out.println("------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closePort();
        }
    }

    static void begin(String name) {
        System.out.printf("%-46s", name);
        m_Tab = 46;
        m_T0 = System.currentTimeMillis();
        m_Progress = 0;
    }

    static protected void sleep(int t) {
        int m = 1000;
        while (t > 0) {
            try {
                Thread.sleep(t > m ? m : t);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            t -= m;
            while ((System.currentTimeMillis() - m_T0) / m > m_Progress) {
                System.out.print(".");
                m_Tab--;
                m_Progress++;
            }
        }
    }


    static public void init(String[] args) {
        m_TestPortName = "cu.usbserial-FTOXM3NX";
        if (args.length > 0) m_TestPortName = args[0];
    }

}