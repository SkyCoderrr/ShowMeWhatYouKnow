# -*- coding: utf-8 -*-
#!/usr/bin/python  
import time
import sys
import os
import subprocess

def restart_program():
    python = sys.executable
    os.system('python google.py')
    res = subprocess.Popen('ps -ef | grep ASRS',stdout=subprocess.PIPE,shell=True)
    attn=res.stdout.readlines()
    counts=len(attn)
    print(counts)
    if counts<1:
    	os.system('python start.py')

if __name__ == "__main__":
    print('start...')
    time.sleep(5)
    path = "1"
    imgs = os.listdir(path)
    if len(imgs) > 0:
        restart_program()