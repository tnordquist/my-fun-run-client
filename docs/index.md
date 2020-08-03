# My Fun Run

## Introduction

_My Fun Run_ is an Android virtual themed race app. Allowing the user to track and save their
 routes while utilizing themed race mode options to simulate real life theme runs. This
 ultra-immersive running game will get any user motivated to get running and achieve their goals.
 
 Users will be able to track their distance, time and pace for each run. Users will be able to start 
 and end their runs at any time. They will be able to choose from one of the available themes where 
 audio and visuals will occur through their run to encourage and engage them while simulating the
 experience of a live themed run. Users can view visuals and hear audio prompts during their runs as
 a part of this experience. If a user does not want to utilize a theme they can opt for a simple 
 timed run option. Stats from runs can be stored for viewing later.
 
 My motivation for building this app is because I do not like to run long distances. I do, however,
 really enjoy theme races and thought that this app could not only help motivate people but in this 
 unique season where theme runs have been cancelled, this will allow uses to feel as if they are 
 participating in these fun and exciting races.
 
 After using Google Sign-in there are three key functional components to my app. The first component
 is that users are able to choose a race theme that will give the use audio prompts as they run.
 Users can also choose to skip a race mode and just use this app as a run tracker. While in the 
 chosen race theme the app also tracks your time, distance and pace. Lastly, after ending your run,
 the user can store stats to be viewed later. To be more motivational and interactive users can make 
 comments on other user's runs. Stretch goals currently include adding, GPS, an accelerometer, timer 
 and users being able to set training goals. My Fun Run app is practical and fun!
 

## Design Documentation

* [Wireframe diagram](wireframe.md)

* [Entity-relationship diagram](erd.md)


## Intended Users and User Stories

* Race enthusiasts who compete in multiple races and train regularly.

    > As an ultra-runner who runs long hours, I want to be able to track my runs so that I can see 
                       my progress while training.

* Someone who is new to running and has not developed the discipline of running.

    > I am new to running, and I am looking for help staying motivated, so I can reach my goals!
          
* Someone runs regularly but feels "stuck" in their routine and is looking for something new.
    > I run regularly along my same route and would like something new and exciting without having 
                  to go far from home.                                                                                      
                                                                                                                                                                                             
 ## Summary of Current State of Application
 
 My Fun Run is currently in mid-development. The app runs on an emulator (Pixel 3a API 28), but you
 are not able to fully execute the app. I have successfully ran the app in horizontal and vertical
 views.Once you sign-in through Google you are brought to a blankHome screen. Using bottom navigation you
 can move to the Race selection screen. There you will find a list of races, you can edit the race 
 details, but you cannot navigate beyond that point. In other words, you are not able to 
 begin tracking your run. Once you select a run an alert dialog box does show up and allows you an 
 'edit' option and will have an option to 'start race' at a later stage in development. At that
 point, you would begin running while the app accesses GPS to track your distance. GPS has not been 
 added to the app yet. The app will also need a timer to track time the user runs which has not been 
 added yet. You can also navigate from the home screen to the History screen and back to Home. The
 History Fragment is currently blank. 
 
#### Improvements
 * Add audio to race themes
 * Add visuals
 * Add color
 
#### Stretch Goals
 * Add GPS
 * Add Timer
 * Add Accelerometer
 * User can set goals
                                                                                               
## Devices and External Services

This app will utilize a variety of devices and/or services to provide the best user experience 
possible. Below is a list of such devices and/or services.

* GPS
    >This will allow users to track their distance while running.
    >https://developer.android.com/training/articles/wear-location-detection

* Push Notifications
    >This will allow users to stay motivated by receiving notification reminders.
    >https://developer.android.com/guide/topics/ui/notifiers/notifications

* Google login
    > This allows users an easy login process.
    >https://developers.google.com/android/guides/http-auth

* Accelerometer
    > This platform provides several sensors that let you monitor the motion of a device relative to
                  > the actions of the user. When the user begins running the accelerometer measures
                  > the increase in motion and will be used to capture the cadence of the user.
    >https://developer.android.com/guide/topics/sensors/sensors_motion

* Timer/Clock
    > This will be used to track the length of the user's run.
    >https://developer.android.com/guide/components/intents-common#CreateTimer

* Audio Visuals
    >The app will use audio and UI visuals to provide the theme experience. These will be the 
    prompts users see and hear while using the app.
    >https://developer.android.com/guide/topics/media/mediarecorder
                 
## Implementation 

* [Entity Classes](https://github.com/christie274/my-fun-run/tree/master/app/src/main/java/edu/cnm/deepdive/myfunrun/model/entity)

* [Dao Interfaces](https://github.com/christie274/my-fun-run/tree/master/app/src/main/java/edu/cnm/deepdive/myfunrun/model/dao)

* [Repositories and Database](https://github.com/christie274/my-fun-run/tree/master/app/src/main/java/edu/cnm/deepdive/myfunrun/service)

* [Fragments](https://github.com/christie274/my-fun-run/tree/master/app/src/main/java/edu/cnm/deepdive/myfunrun/controller)

* [Pojo Classes](https://github.com/christie274/my-fun-run/tree/master/app/src/main/java/edu/cnm/deepdive/myfunrun/model/pojo)

* [Data Definition Language](ddl.md)

 
 ## Build Instructions
 * [Build Instructions](build_instructions.md)
 
 ## Basic User Instructions
 * [Basic User Instructions](basic_user_instructions.md)

## License information

_My Fun Run_ was written by Christie Ryan.

Copyright 2020 Deep Dive Coding/CNM Ingenuity, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

For copyright &amp; license information on the libraries incorporated into _My Fun Run_, see 
[_Notice_](notice.md). 
