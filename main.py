from gpiozero import LED
# import time
# import sys

pin = 21
# pin = sys.argv[1]
print("LED pin: ", pin)
try:
    led = LED(pin)
    led.off()
    # time.sleep(5)
    led.on()
    print("LED on")
except Exception as e:
    print(e)
    print("Usage: python main.py <pin_number>")
finally:
    led.off()
    print("LED off")
