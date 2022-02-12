echo "[*] 실행되고 있는 efub 컨테이너 중지"
sudo docker stop efub

echo "[*] 중지된 efub 컨테이너 삭제"
sudo docker rm efub

echo "[*] 새로운 이미지 pull 받기"
sudo docker pull hoit1302/efub:latest

echo "[*] 새로운 이미지 확인하기"
sudo docker images

echo "[*] 새로운 이미지 백그라운드로 실행하기"
sudo docker run --name efub -d -p 8080:8080 hoit1302/efub:latest

echo "[*] 실행되고 있지 않는 이미지 삭제하기"
sudo docker images prune -a -f

echo "[*] 삭제된 이미지 확인하기"
sudo docker images
