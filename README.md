# 🚀 AI Log Monitor

A real-time, event-driven log analysis system built with **Spring Boot**, **Apache Kafka**, and **Local AI (Ollama)**.

## 🛠️ Tech Stack
- **Backend:** Java 17, Spring Boot 3
- **Messaging:** Apache Kafka & Zookeeper
- **AI Engine:** Ollama (TinyLlama / Phi-3)
- **Database:** MySQL 8
- **Containerization:** Docker & Docker Compose

## 🏗️ Architecture
1. **Log Producer:** A REST API that receives logs and pushes them to Kafka.
2. **Log Consumer:** Listens to Kafka, sends logs to a local AI model via Ollama for root-cause analysis, and saves the result to MySQL.
3. **Dashboard:** A Thymeleaf-based UI to visualize logs and AI-generated fixes.

## 🚀 Quick Start

### Prerequisites
- Docker & Docker Compose
- [Ollama](https://ollama.com/) installed on your host machine.

### Run with Docker
1. **Clone the repo:**
   ```bash
   git clone [https://github.com/yourusername/ai-log-monitor.git](https://github.com/yourusername/ai-log-monitor.git)
   cd ai-log-monitor
   
2. Build the apps
   
   cd log-producer && mvn clean package -DskipTests
cd ../log-consumer && mvn clean package -DskipTests
cd ..

4. start the stack
  docker-compose up -d
  
5. Access the Dashboard: http://localhost:8082/dashboard  
