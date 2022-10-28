# coding=utf-8
print("Hello World!")

print ("你好，世界")

list = ["a", "b", "c"]
print(list)

# input("输入字符，按回车结束。。。\n")

var1 = 1
print(var1)
del var1 # 删除索引
# print(var1)

# 字符串截取 str[头下标:尾下标]  包含头 不包含尾   下标从右到左 -1开始
# str[头下标:尾下标:步长] 包含头，不包含尾，按步长截取
#最常用的数据结构 list 标识符 [] 截取也可以使用头下标 尾下标

# 元组 Tuple  标识符 ()
tuple = ( 'runoob', 786 , 2.23, 'john', 70.2 )
tinytuple = (123, 'john')

print (tuple)               # 输出完整元组
print (tuple[0])            # 输出元组的第一个元素
print (tuple[1:3])         # 输出第二个至第四个（不包含）的元素
print (tuple[2:])           # 输出从第三个开始至列表末尾的所有元素
print (tinytuple * 2)       # 输出元组两次
print (tuple + tinytuple)   # 打印组合的元组
# 以下对元组的操作是无效的，因为元组不允许更新，而列表是允许更新的：
tuple = ( 'runoob', 786 , 2.23, 'john', 70.2 )
list = [ 'runoob', 786 , 2.23, 'john', 70.2 ]
#tuple[2] = 1000    # 元组中是非法应用
list[2] = 1000     # 列表中是合法应用


# 字典 列表是有序的对象集合，字典是无序的对象集合。
# 两者之间的区别在于：字典当中的元素是通过键来存取的，而不是通过偏移存取。
# 字典用"{ }"标识。字典由索引(key)和它对应的值value组成。
dict = {}
dict['one'] = "This is one"
dict[2] = "This is two"

tinydict = {'name': 'runoob','code':6734, 'dept': 'sales'}
print (dict['one'])          # 输出键为'one' 的值
print (dict[2])              # 输出键为 2 的值
print (tinydict)             # 输出完整的字典
print (tinydict.keys())      # 输出所有键
print (tinydict.values())   # 输出所有值


# 数据类型转换  只需要将要转换的数据类型作为函数名即可，把待转换的数据传入
var2 = 123
print(str(var2))

# 判断一个对象是否在list中 可以直接用 in   not in 判断
# 比较两个对象的索引  is   is not

# 格式化字符串 %
print("my name is : %s" % "sam")

list2 = ["a","b","c"]
list3 = ["b","c"]
print(set(list2).__dict__(set(list3)))
