from PIL import Image

ascii_char = list(' "$%_&WM#*oankbdpqwmZO0QLCJUYXzcvunxrjft/\|()1{}[]?-/+@<>i!;:\^.`\'')
def get_char(r,b,g,alpha=256):
    if alpha == 0:
        return ' '

    gray = int(0.2126*r+0.752*g+0.0722*b)
    unit = 256/len(ascii_char)
    return ascii_char[int(gray//unit)]

def main():
    im = Image.open("C:/Users/user/Desktop/111.png")
    WTDTH,HEIGHT = 100,60
    im = im.resize((WTDTH,HEIGHT))
    txt = ""
    for i in range(HEIGHT):
        for j in range(WTDTH):
            txt += get_char(*im.getpixel((j,i)))
            txt += '\n'
    fo.open("C:/Users/user/Desktop/111.txt","w")
    fo.write(txt)
    fo.close()
main()