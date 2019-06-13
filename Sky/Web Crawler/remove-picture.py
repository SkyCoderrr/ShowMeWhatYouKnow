import os,sys
from PIL import Image

path = "1"
imgs = os.listdir(path)
len_imgs = len(imgs)
for i in range(len_imgs):
    try:
        im = Image.open(path + "/" + imgs[i])
        width, height = im.size
        im.close()
        if height < 701:
            print(im.filename)
            os.remove(im.filename)
    except:
        os.remove(path + "/" + imgs[i])
        continue