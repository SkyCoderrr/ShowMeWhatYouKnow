from urllib.request import Request, urlopen
from urllib.parse import urlencode
import subprocess
import urllib
import re
import os
import json
import time
from selenium import webdriver

import hashlib

def getallfiles(path):
    allfile=[]
    for dirpath,dirnames,filenames in os.walk(path):
        for dir in dirnames:
            allfile.append(os.path.join(dirpath,dir))
        for name in filenames:
            allfile.append(os.path.join(dirpath, name))
    return allfile
if __name__ == '__main__':
    # create a new Firefox session
    filename = 'C:\\Users\\lenovo\\Desktop\\google\\1' #***change this path to the path of the folder '1' on your computer***
    allfile=getallfiles(filename)
    download_file = open('download_list.txt','a')
    driver = webdriver.Firefox()
    driver.implicitly_wait(30)
    for file in allfile:
        if file.endswith('.jpg'):
            print(file)
            driver.get("https://www.google.com.sg/imghp?hl=zh-CN&tab=wi")
            img_search = driver.find_element_by_class_name("S3Wjs")
            img_search.click()
            time.sleep(1)
            driver.execute_script("google.qb.ti(true);return false")
            time.sleep(1)
            img_file = driver.find_element_by_id("qbfile")
            img_file.send_keys(file)
            driver.implicitly_wait(100)
            try:
                link = driver.find_element_by_class_name("iu-card-header")
            except:
                # driver.close()
                os.remove(file)
                continue
            link.click()
            pics = driver.find_elements_by_class_name("rg_ic")
            temp = 0
            for pic in pics:
                temp += 1
                if temp > 70:
                    continue
                try:
                    pic.click()
                    image_panels = driver.find_elements_by_class_name('irc_mic')
                    for pn in image_panels:
                        img_url = pn.find_element_by_tag_name("img").get_attribute("src")
                        print(img_url)
                        download_file.write(img_url)
                        download_file.write('\n')
                except Exception as e:
                    continue
            os.remove(file)
    driver.close()
    download_file.close()
    #subprocess.call(["python","set.py"])
    #subprocess.call(["python","download.py"])
    #subprocess.call(["python","remove.py"])