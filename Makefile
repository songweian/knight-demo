mvn-test:
	cd backend && mvn test
mvn-build:
	cd backend && mvn clean package
webui-build:
	cd webui && npm install && npm run build
