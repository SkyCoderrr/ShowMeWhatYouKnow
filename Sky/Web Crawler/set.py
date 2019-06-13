import os
rFile = open('download_list.txt', 'r')
wFile = open("b.txt", "w")
allLine = rFile.readlines()
rFile.close()
h = {}
for i in allLine:
    if i not in h:
        h[i]=1
        wFile.write(i)
wFile.close()