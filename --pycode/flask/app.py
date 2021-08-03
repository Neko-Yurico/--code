from flask import Flask,render_template,render_template_string

app = Flask(__name__)

# {{ ... }} 装载变量 模板渲染的时候将传进来的参数把这个值替换
# {% ... %} 装载控制语句的 if、for
# {# ... #} 装载一个注释


# render_template渲染指定文件
# render_template_string渲染一个字符串


@app.route('/') # 根路由
@app.route('/index') # index路由
# http://127.0.0.1:5000/index



def hello_world():
#    html="<h1>hello<h1>"

    user={'name':'world'}
    return render_template('index.html',user=user)


if __name__ == '__main__':
    app.run()
