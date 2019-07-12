from PIL import Image
im = Image.open("C:/Users/user/Desktop/222.gif")  #读入一个gif文件
try:
    im.save("C:/Users/user/Desktop/picframe{:02d}.png".format(im.tell()))
    while True:
        im.seek(im.tell()+1)
        im.save("C:/Users/user/Desktop/picframe{:2d}.png".format(im.tell()))
except:
    print("处理结束")