from urllib.request import Request, urlopen
from urllib.parse import urlencode
import urllib
import re
import os
from selenium import webdriver
import hashlib
def hash_file(path, output_dir):

    with open(path, 'rb') as f:
        sha1obj = hashlib.sha1()
        sha1obj.update(f.read())
        file_hash = sha1obj.hexdigest()
    name, ext = os.path.splitext(path)
    filename = output_dir + '\\' + file_hash + ext
    if not os.path.exists(filename):
        os.rename(path, filename)
    else:
        os.remove(path)

output_dir = 'C:\\Users\\lenovo\\Desktop\\google\\1'#***change this path to the path of the folder '1' on your computer***
counter = len(os.listdir(output_dir))
new_image_name = output_dir + "\\" + "new_image.jpg"
download_list = open('b.txt')
for line in download_list.readlines():
    with open('downloaded.txt','a') as mon:
        mon.write(line)
    line2 = line.split('\n')
    line3 = line2[0]
    print(line3)
    try:
        urllib.request.urlretrieve(line3,new_image_name)
        hash_file(new_image_name, output_dir)
        counter += 1
    except:
        continue
download_list.close()