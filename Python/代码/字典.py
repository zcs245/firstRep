Dcountry = {"中国":"北京","美国":"华盛顿","法国":"巴黎"}
print(Dcountry,"\n",Dcountry["中国"])

Dcountry["中国"] = "大北京"
print(Dcountry)

Dcountry = {"中国":"北京","美国":"华盛顿","法国":"巴黎"}
Dcountry["英国"]="伦敦"
print(Dcountry)

Dp = {}
Dp['2^10'] = 1024
print(Dp)

Dcountry = {"中国":"北京","美国":"华盛顿","法国":"巴黎"}
print(Dcountry.keys(),"\n",list(Dcountry.values()),"\n",Dcountry.items(),"\n","中国" in Dcountry,"\n",
      Dcountry.get("美国","悉尼"),"\n",Dcountry.get("澳大利亚","悉尼"))
for key in Dcountry:
    print(key)
