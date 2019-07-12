from random import random
from math import sqrt
import time
DATES = 2**20
hits = 0.0
t=time.perf_counter()
for i in range(1,DATES+1):
    x,y = random(),random()
    dist = sqrt(x**2+y**2)
    if dist <= 1.0:
        hits = hits +1
pi = 4*(hits/DATES)
t -= time.perf_counter()
print("pi的值是{}".format(pi))
print("运行时间是：{:.5f}s".format(-t))
