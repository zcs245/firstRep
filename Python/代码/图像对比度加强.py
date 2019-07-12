from PIL import Image
from PIL import ImageEnhance
im = Image.open("C:/Users/user/Desktop/111.png")
om = ImageEnhance.Contrast(im)
om.enhance(20).save('C:/Users/user/Desktop/111_contrast.png')