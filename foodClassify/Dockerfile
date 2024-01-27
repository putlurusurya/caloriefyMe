FROM python:3.8
COPY . .
WORKDIR /

RUN pip install --upgrade pip && \
    pip install --no-cache-dir -r requirements.txt

EXPOSE 5000

CMD flask run -h 0.0.0.0 -p 5000