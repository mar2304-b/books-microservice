#!/bin/bash

set -e

BACKEND_DIR=${1:-"./books"}
DB_DIR=${2:-"./db"}

BACKEND_IMAGE="mariana23/parcial_c2:latest"
DB_IMAGE="mariana23/parcial_c2:latest"

echo "📦 Building backend image from: $BACKEND_DIR..."
docker build -t $BACKEND_IMAGE $BACKEND_DIR/ || {
  echo "❌ Backend build failed!"
  exit 1
}

echo "⬆ Pushing backend image to Docker Hub..."
docker push $BACKEND_IMAGE || {
  echo "❌ Backend push failed!"
  exit 1
}

echo "📦 Building db image from: $DB_DIR..."
docker build -t $DB_IMAGE $DB_DIR/ || {
  echo "❌ Frontend build failed!"
  exit 1
}

echo "⬆ Pushing db image to Docker Hub..."
docker push $DB_IMAGE || {
  echo "❌ Frontend push failed!"
  exit 1
}

echo "🚀 Starting containers..."
docker compose up -d --build || {
  echo "❌ Failed to start containers!"
  exit 1
}

echo "✅ Deployment completed successfully!"