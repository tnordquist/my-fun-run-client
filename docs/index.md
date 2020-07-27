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

## Design Documentation

* [Wireframe diagram](wireframe.md)

* [Entity-relationship diagram](erd.md)

## Intended Users and User Stories

* Race enthusiasts who compete in multiple races and train regularly.

    > As an ultra-runner who runs long hours, I want to be able to track my runs so that I can see 
                       my progress while training.

* Someone who is new to running and has not developed the discipline of running.

    > I am new to running, and I am looking for help staying motivated, so I can reach my goals!
          
* Someone runs regularly but is feeling "stuck" in their routine and is looking for something new.
    > I run regularly along my same route and would like something new and exciting without having 
                  to go far from home.

    
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

## Stretch Goals
 * Adding a section for users to set goals
 * Adding a leaderboard for users to compete
 * Allowing comments between users

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

For copyright &amp; license information on the libraries incorporated into _My Fun Run_, see [_Notice_](docs/notice.md).
