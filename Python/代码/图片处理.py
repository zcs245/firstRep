from PIL import Image
im = Image.open("C:/Users/user/Desktop/111.png")
r,g,b,a = im.split()
newg = g.point(lambda i:i*9)
newb = b.point(lambda i:i<100)
om = Image.merge("RGBA",(r,newg,newb,a))
om.save("C:/Users/user/Desktop/111_n.png")