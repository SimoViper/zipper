# Zipper Application

This Spring boot application creates and returns a zip file given a list of files in input.

## Usage
the **url** to the POST operation is  
http://localhost:8080/zip 

the **body** content type is form-data and has to contain the list of files.

A **postman** collection with a request to test the service manually
is provided in the root of the project, in order to download the zip file is necessary to open the 
combo box near the button "Send" and select "Send and Download".

## Docker instructions

in order to create the docker image navigate in the root of the project and run the command:

docker build -t exercise/zipper .

in order to create the container and run the image:

docker run -p 8080:8080 exercise/zipper




