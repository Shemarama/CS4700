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

def firstPrimeNumbers(n):
    '''firstPrimeNumbers(n) ---> Prints the first n prime numbers.'''
    if n < 1:
        return
    # since 2 is the first prime number
    count = 1
    i = 2
    print '%d: %d' % (count, i)
    i += 1
    while count < n:
        if is_prime(i):
            count += 1
            print '%d: %d' % (count, i)
        i += 2

def timeIt(f,n):
    s = time.time()
    f(n)
    print 'Time: %f seconds' % (time.time()-s)


n = 1000
timeIt(firstPrimeNumbers,n)