t# week3project

## Domain

The project domain of this application is data analysis and algorithmic matching. We will obtain a wide range of data from a set of users, analyze the data, and then use a series of algorithms to match users based on the data they have provided. 

A distinctive feature of this application will be the ability to send songs directly from one device to another, much like Apple's "AirDrop" feature for sharing content. This feature will be a part of the data-obtaining process that we will use to create matches.

The main goal of the matching algorithms is optimization, i.e. finding one or more "optimal" matches. However, unlike traditional matching algorithms whose output depends directly on input provided, our algorithms will also analyze possible trends in the data, use these patterns to predict the kind of data the user will provide in the future, and use the predicted data alongside the given data to match users together. Taking predicted data into account introduces a more personalized approach to creating meaningful matches; users will not only be paired based on how similar their music tastes are, but also on the potential to evolve and enliven each other's music taste and form a connection based on that!   


## Overview

Our team is looking to create a music dating app called MicDrop (tentative) that matches people based on the similarity of their music taste. Using the Spotify API, we can acess a user's listening history, made playlists, liked playlists, etc. to form a taste profile and assess complimentary profiles. We are able to use this data to create a multitude of options; a simple matching option based on similar tastes in genre or artists, an opposites attract section based on disimilarites, and more. (Potential add-on) Using a geo-location API, we can region lock the potential matches to a user given radius.

## API Options

[Spotify API](https://developer.spotify.com/documentation/web-api?ref=apilist.fun)

![alt text](https://github.com/vikines-s/week3project/blob/main/apiAcess.jpeg?raw=true)
![alt text](https://github.com/vikines-s/week3project/blob/main/tokenDetails.jpeg?raw=true)
![alt text](https://github.com/vikines-s/week3project/blob/main/userInfoCall.jpeg?raw=true)

## Example Output
`User Information:
{  "display_name" : "applehatter",  "external_urls" : {    "spotify" : "https://open.spotify.com/user/applehatter"  },  "href" : "https://api.spotify.com/v1/users/applehatter",  "id" : "applehatter",  "images" : [ ],  "type" : "user",  "uri" : "spotify:user:applehatter",  "followers" : {    "href" : null,    "total" : 18  }}
`


## Technical Problems
a list of any technical problems blocking progress (if any)
