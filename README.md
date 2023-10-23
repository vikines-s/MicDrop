# MicDrop

## Domain

The project domain of this application is the realm of online dating. With the advent of many apps such as Tinder, Hinge, and so on, we wanted to add our own software into the mix to understand how music can result in more meaningful matches and connections. Our application will involve a lot of data analysis and algorithmic matching - we will obtain a wide range of data from a set of users, analyze the data, and then use a series of algorithms to match users with each other based on the musical data we have learned about them. 

The main goal of the matching algorithms is optimization, i.e. finding one or more "optimal" matches. However, unlike traditional matching algorithms whose output depends directly on input provided, our algorithms will also analyze possible trends in the data, use these patterns to predict the kind of data the user will provide in the future, and use the predicted data alongside the given data to match users together. Taking predicted data into account introduces a more personalized approach to creating meaningful matches; users will not only be paired based on how similar their music tastes are, but also on the potential to evolve and enliven each other's music taste and form a connection based on that!   


## Overview

Our team is looking to create a music dating app called MicDrop (tentative) that matches people based on the similarity of their music taste. Using the Spotify API, we can access a user's listening history, playlists, liked playlists, etc., to form a taste profile and assess complimentary profiles. We are able to use this data to create a multitude of options; a simple matching option based on similar tastes in genre or artists, an opposites attract section based on disimilarites, and more. (Potential add-on) Using a geo-location API, we can region-lock the potential matches to a user's given radius.

## API Options

[Spotify API](https://developer.spotify.com/documentation/web-api?ref=apilist.fun)

![alt text](https://github.com/vikines-s/week3project/blob/main/apiAcess.jpeg?raw=true)
![alt text](https://github.com/vikines-s/week3project/blob/main/tokenDetails.jpeg?raw=true)
![alt text](https://github.com/vikines-s/week3project/blob/main/userInfoCall.jpeg?raw=true)

## Example Output
```java
User Information:
{  "display_name" : "applehatter",  "external_urls" : {    "spotify" : "https://open.spotify.com/user/applehatter"  },  "href" : "https://api.spotify.com/v1/users/applehatter",  "id" : "applehatter",  "images" : [ ],  "type" : "user",  "uri" : "spotify:user:applehatter",  "followers" : {    "href" : null,    "total" : 18  }}
```


## Technical Problems
Our biggest technical challenges are related to accessing information from Spotify and implementing a potential geolocation API. We had quite a bit of trouble figuring out how we can access user information from this music app, and there will be quite the authorisation process each time someone logs in - we should implement this properly. Additionally, if we are to integrate a geolocation feature where people can view what potential matches in their vicinity are listening to, this will involve integrating both the Spotify and Geolocation API together, which would be quite the technical challenge.
