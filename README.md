# Jenkins and Docker Setup on Ubuntu and Windows

This README provides detailed instructions for installing Java, Jenkins, and Docker, along with setting up Jenkins to run Docker containers on both Ubuntu and Windows. 

## Prerequisites

- A server or local machine running Ubuntu or Windows.
- Administrative access to install software.

## Table of Contents

1. [Installation on Ubuntu](#installation-on-ubuntu)
   - [Install Java](#install-java)
   - [Install Jenkins](#install-jenkins)
   - [Install Docker](#install-docker)
   - [Configure Jenkins to Run Docker](#configure-jenkins-to-run-docker)
   - [Docker Run Example](#docker-run-example)
  
2. [Installation on Windows](#installation-on-windows)
   - [Install Java](#install-java-1)
   - [Install Jenkins](#install-jenkins-1)
   - [Install Docker](#install-docker-1)
   - [Configure Jenkins to Run Docker](#configure-jenkins-to-run-docker-1)
   - [Docker Run Example](#docker-run-example-1)

3. [Additional Configuration](#additional-configuration)

---

## Installation on Ubuntu

### Install Java

Open a terminal and run:

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### Install Jenkins

Run the following commands to install Jenkins:

```bash
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key

echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/" | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null

sudo apt-get update
sudo apt-get install jenkins
```

### Install Docker

Run these commands to install Docker:

```bash
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates curl software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

sudo apt-get update
sudo apt-get install docker-ce

sudo docker run hello-world
```

### Set Custom Port 8080 on AWS Security Group

If you're using AWS, ensure that the security group associated with your instance allows inbound traffic on port 8080 for Jenkins.

### Give Permission for Docker Run via Jenkins

Add the Jenkins user to the Docker group to allow it to run Docker commands:

```bash
sudo usermod -aG docker jenkins
sudo systemctl restart jenkins
```

### Docker Run Example

You can build and run a Docker container as follows:

```bash
sudo docker build -t web_test_automation .
sudo docker run --rm web_test_automation
```

---

## Installation on Windows

### Install Java

Download and install the [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) for Windows. Make sure to set the `JAVA_HOME` environment variable to the JDK installation path.

### Install Docker

1. Download and install [Docker Desktop](https://www.docker.com/products/docker-desktop).
2. Ensure that Docker is running.


#### Jenkins Setup 

## 1. Jenkins Installation

1. **Download Jenkins:**
   Download the installer from the [Jenkins website](https://www.jenkins.io/download/).

2. **Run the Installer:**
   Follow the installation wizard instructions.

3. **Access Jenkins:**
   Open a web browser and navigate to `http://localhost:8080`. Retrieve the initial admin password from the `C:\Program Files (x86)\Jenkins\secrets\initialAdminPassword`.

4. **Complete Setup Wizard:**
   Enter the password and follow the on-screen instructions to finish setup.


## 2. Necessary Plugin Installation

1. **Open Jenkins Dashboard:**
   - Navigate to **`Manage Jenkins` > `Manage Plugins`**.

2. **Install the Following Plugins:**
   - **Git Plugin**
   - **Git Server**
   - **Pipeline: Stage View Plugin**
   - **Oracle Java SE Development Kit Installer Plugin**
   - **Maven Integration Plugin**
   - **Pipeline Maven Integration Plugin**
   - **Docker Pipeline**
   - **Docker Pipeline Plugin**
   - **Docker Slaves Plugin**
   - **Allure Plugin**

---

This format organizes the steps into a clear and concise list, making it easier for readers to follow.


3. **Installation Steps:**
   - Go to the **Available** tab, search for each plugin, check the boxes, and click **Install without restart**.

---

## 3. Tool Configuration

### Configure Git

1. **Navigate to:**
   `Manage Jenkins` > `Global Tool Configuration`.

### Configure Maven installations
    - Click Add Maven
    - Enter Name
    - Click Apply


### Configure Add Allure Commandline
    - Click Add Allure Commandline
    - Enter Name
    - Click Save


## 4. GitHub Configuration

### Generate GitHub Personal Access Token

1. Go to your GitHub account settings.
2. Under **Developer settings**, select **Personal access tokens**.
3. Click **Generate new token**, select the necessary scopes (like `repo`), and copy the token.

### Configure Jenkins Credentials

1. **Navigate to:**
   `Manage Jenkins` > `Manage Credentials`.

2. **Add Credentials:**
   - Click on **(global)** > **Add Credentials**.
   - Choose **Username with password** and enter your GitHub username and the personal access token as the password.


## 5. Creating and Running a Job

### Create a New Job

1. **Navigate to Jenkins Dashboard:**
   Click on **New Item**.

2. **Enter Job Name:**
   Enter a name for your job and select **Pipeline** .

3. **Configure Source Code Management:**
   - Under **Pipeline**, select **Pipeline Script**.
   - Enter Pipeline Script. **Change credentialsId**


5. **Save and Build:**
   Click **Save** and then **Build Now** to run your job.

---


### If You Run without Jenkins then run only Docker:

Open a terminal or command prompt and run:

```bash
docker build -t web_test_automation .
docker run --rm web_test_automation
```

---
