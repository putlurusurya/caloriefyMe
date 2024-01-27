from flask import Flask , redirect , url_for , request , render_template
from werkzeug.utils import secure_filename
import tensorflow as tf
from tensorflow.keras.applications.inception_v3 import preprocess_input
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing import image
from tensorflow import keras
import os
import numpy as np


app = Flask(__name__)

Model_path = 'model_v1_inceptionV3.h5'
#model = keras.applications.InceptionV3(weights='imagenet')
model=load_model(Model_path)

def model_predict(img_path , model):
    print(img_path)
    img = image.load_img(img_path , target_size=(299 , 299))
    x = image.img_to_array(img)
    x = x / 255 
    x = np.expand_dims(x , axis = 0)

    preds = model.predict(x)
    preds = np.argmax(preds , axis = 1)
    if preds == 0:
        preds = "Burger"

    elif preds == 1:
        preds = "Butter Naan"

    elif preds == 2:
        preds = "Chai"

    elif preds == 3:
        preds = "Chapati"

    elif preds == 4:
        preds = "Bhature"

    elif preds == 5:
        preds = "Dal Makhani"

    elif preds == 6:
        preds = "Dhokla"

    elif preds == 7:
        preds = "Fried Rice"

    elif preds == 8:
        preds = "Idli"

    elif preds == 9:
        preds = "Jalebi"

    elif preds == 10:
        preds = "Kaathi Rolls"
    
    elif preds == 11:
        preds = "Kadai Paneer"

    elif preds == 12:
        preds = "Kulfi"

    elif preds == 13:
        preds = "Masala Dosa"

    elif preds == 14:
        preds = "Momos"

    elif preds == 15:
        preds = "Paani Puri"

    elif preds == 16:
        preds = "Pakode"

    elif preds == 17:
        preds = "Pav Bhaji"

    elif preds == 18:
        preds = "Pizza"

    else:
        preds = "Samosa"

    return preds

@app.route('/' , methods=["GET"])
def index(): 
    return render_template('index.html')

@app.route('/predict' , methods=['GET', 'POST'])
def uploads():
    if request.method == 'POST':
        print("i am here")
        f = request.files['file']

        basepath = os.path.dirname(__file__)
        file_path = os.path.join(basepath , 'uploads' , secure_filename(f.filename))
        f.save(file_path)

        preds = model_predict(file_path , model)
        result = preds
        return result
    return None


if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0')