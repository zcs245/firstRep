from PIL import Image
from PIL import ImageFilter
im = Image.open("C:/Users/user/Desktop/111.png")
om = im.filter(ImageFilter.CONTOUR)
om.save("C:/Users/user/Desktop/111_co.png")