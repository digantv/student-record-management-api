FROM digantv/openjdk:latest
WORKDIR /app

ARG imageName

ENV IMAGE_NAME=${imageName}

COPY /target/${IMAGE_NAME}.jar /app/${IMAGE_NAME}.jar

CMD ["sh", "-c", "java -jar /app/${IMAGE_NAME}.jar"] 