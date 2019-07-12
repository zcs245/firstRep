from PIL import Image
import numpy as np
wec_el = np.pi/2.2 #光源的俯视角，弧度值
wec_az = np.pi/4   #光源的方位角度，弧度值
depth = 10. #（1-100）
im = Image.open("C:/Users/user/Desktop/111.png").convert('L')
a = np.asarray(im).astype('float')
grad = np.gradient(a) #取得图像灰度的梯度值
grad_x,grad_y = grad #分别取横纵图像梯度值
grad_x = grad_x*depth/100.
grad_y = grad_y*depth/100.
dx = np.cos(wec_el)*np.cos(wec_az) #光源对X轴的影响
dy = np.cos(wec_el)*np.sin(wec_az) #光源对Y轴的影响
dz = np.sin(wec_el)  #光源对Z轴的影响
A = np.sqrt(grad_x**2 + grad_y**2 +1.)
uni_x = grad_x/A
uni_y = grad_y/A
uni_z = np.sqrt(1./A)
a2 = 255*(dx*uni_x + dy*uni_y +dx*uni_z)    #光源归一化
a2 = a2.clip(0,255)
im2 = Image.fromarray(a2.astype('uint8')) #重构图像
im2.save("C:/Users/user/Desktop/222.png")