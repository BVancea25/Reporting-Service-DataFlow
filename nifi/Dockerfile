FROM apache/nifi:latest

USER root
RUN apt-get update \
    && apt-get install -y net-tools curl \
    && rm -rf /var/lib/apt/lists/*
USER nifi
