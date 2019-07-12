from PIL import Image
import numpy as np

# im = np.array(Image.open("C:/Users/user/Desktop/111.png"))
# print(im.shape,im.dtype)
#
# im = np.array(Image.open("C:/Users/user/Desktop/111.png").convert('L'))
# print(im.shape,im.dtype)

im0 = np.array(Image.open("C:/Users/user/Desktop/111.png").convert('L'))
im1 = 255-im0 #反变换
im2 = (100/255)*im0 + 150 #区间变换
im3 = 255*(im1/255)**2 #像素平方处理
pill_im = Image.fromarray(np.uint(im0)) #分别执行im0,im1,im2
pill_im.show()