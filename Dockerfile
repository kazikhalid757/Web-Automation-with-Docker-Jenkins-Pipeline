# Use an ARM64-compatible Maven image as a parent image
FROM arm64v8/maven:3.8.4-openjdk-11

# Set the working directory
WORKDIR /usr/src/app

# Install necessary packages
RUN apt-get update \
    && apt-get install -y \
        firefox-esr \
        wget \
        bzip2 \
        xvfb \
        libdbus-glib-1-2 \
    && rm -rf /var/lib/apt/lists/*

# Install GeckoDriver v0.33.0 (ARM64 version)
RUN wget -q https://github.com/mozilla/geckodriver/releases/download/v0.33.0/geckodriver-v0.33.0-linux-aarch64.tar.gz \
    && tar -xzf geckodriver-v0.33.0-linux-aarch64.tar.gz -C /usr/local/bin/ \
    && rm geckodriver-v0.33.0-linux-aarch64.tar.gz \
    && chmod +x /usr/local/bin/geckodriver

# Copy the pom.xml file and download dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:resolve

# Copy the rest of the application
COPY . .

# Run the tests
CMD ["mvn","clean", "test"]
