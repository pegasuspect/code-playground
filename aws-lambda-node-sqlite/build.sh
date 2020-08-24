rm -f function.zip;
zip -rq function.zip . && echo 'Build into funciton.zip' || echo 'Build failed.'