#!/usr/bin/python2

import math
import time

def is_prime(n):
    '''is_prime(n) ---> True if n is prime; False otherwise.'''
    if n < 2:
        return False
    if n == 2:
        return True
    if n%2 == 0:
        return False
    for i in xrange(3,int(math.sqrt(n))+1,2):
        if n%i == 0:
            return False
    return True




n = 10000
s = time.time()
for i in xrange(0,n+1):
    if is_prime(i):
        print '%d is prime' % (i)

print 'Time: %f seconds' % (time.time()-s)
