from PIL import Image
im = Image.open("C:/Users/user/Desktop/111.png")
r,g,b,a= im.split()
om = Image.merge("RGBA",(b,g,r,a))
om.save("C:/Users/user/Desktop/111_c.png")