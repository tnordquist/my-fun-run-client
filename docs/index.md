# My Fun Run

## Introduction

_My Fun Run_ is an Android virtual themed race app. Allowing the user to track and save their
 routes while utilizing themed race mode options to simulate real life theme runs. This
 ultra-immersive running game will get any user motivated to get running and achieve their goals.
 
 Users will be able to track and save their distance, time and pace. Users will be able to start 
 and end their runs at any time. They will be able to choose from one of the available themes where 
 audio and visuals will occur through their run to encourage and engage the user. Users can view
 visuals and hear audio prompts during their runs. If a user does not want to utilize a theme they 
 can opt for a timed run option. Stats from runs can be stored for viewing later.

## Design documentation

* [Wireframe diagram](wireframe.md)

* [Entity-relationship diagram](erd.md)

## User Stories

* Race Enthusiasts 

    > As a ultra-runner who runs long hours, I want to be able to track my runs so that I can see 
                       >my progress while training.

* New Runners

    > As someone who is new to running I am looking for help staying motivated!
          
* Bored Runners
    > I run regularly along my same route and would like something new and exciting without having 
                  >to go far from home.

## Functionality

* Tracks distance traveled, time, and pace

* App stores above mentioned stats for each activity so user can track progress from run to run, 
    daily, weekly, or monthly.

* Developer will provide start, stop, and pause options

* Developer will create race mode options, user can choose race type/theme

* Developer will create pre-programmed alerts. As user approaches markers along the desired course,
    push notifications would send user alerts for motivation. Markers would be identified by 
    distance traveled.
    
## Devices and external services

This app will utilize a variety of devices and/or services to provide the best user experience 
possible. Below is a list of such devices and/or services.

* GPS
    >This will allow users to track their distance while running.
    >https://developer.android.com/training/articles/wear-location-detection

* Push Notifications
    >This will allow users to stay motivated by receiving notification reminders.
    >https://developer.android.com/guide/topics/ui/notifiers/notifications

* Google Play Store
    > By publishing this app more people will be able to see it.
    >https://developer.android.com/distribute/google-play
    https://developer.android.com/distribute/best-practices/launch/launch-checklist

* Google login
    > This allows users an easy login process.
    >https://developers.google.com/android/guides/http-auth

* Bluetooth
    > This will allow the user the ability to connect for a hands free experience.
    >https://developer.android.com/guide/topics/connectivity/bluetooth

* Accelerator
    > This will help the app gather user run stats.
    >https://developer.android.com/guide/topics/sensors/sensors_motion

* Timer/Clock
    > This will be used to track the length of the user's run.
    >https://developer.android.com/guide/components/intents-common#CreateTimer

*Audio Visuals
    >The app will use audio and UI visuals to provide the theme experience. These will be the 
    prompts users see and hear while using the app.
    >https://developer.android.com/guide/topics/media/mediarecorder
                 