rm -f function.zip node_modules package-lock.json;
npm i && zip -rq function.zip index.js node_modeules && echo 'Build into funciton.zip' || echo 'Build failed.'