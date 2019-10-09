Hvordan unngå HTTPS under utvikling



## Recycler View

## Volley - wrapper rundt http

## Parse JSON

Ved erndring fra landscape til portrait så stenges applikasjonen ned.



Fragments - en view inni en komponent. Fylle med innholdet. Splitter opp GUI i flere views.

View model - set med interacterende elementer. Ved stenging av app så lager vi callback til dette elementet for å lagre på disk. Ny callback ved gjennåpning av app. slik at vi kan få opp elementet der vi var. 

ImageView- tar inn bitmapp. Decode bilde ved henting. Putte bitmapp inn i ImageView. => Picasso https://square.github.io/picasso/





Scroll list- bruker veldig mye minne hvis man laster inn alt også klipper vekk det vi ikke trenger

## App Components

All andrioid apps can consist of these basic components to help fullfill there tasks. 

> A unique aspect of the Android system design is that any app can start another app’s component. For example, if you want the user to capture a photo with the device camera, there's probably another app that does that and your app can use it instead of developing an activity to capture a photo yourself. You don't need to incorporate or even link to the code from the camera app. Instead, you can simply start the activity in the camera app that captures a photo. When complete, the photo is even returned to your app so you can use it. To the user, it seems as if the camera is actually a part of your app.

### Activeties

One app can have several activeties that are independent from each other. Activeties can also be called from other aps. Eg. emaillist activity, compose email activity, email contact activity.

> You implement an activity as a subclass of the `Activity` class.

### Services

Runs in the background to complete tasks for the app. Eg. plays music in the background, or fetches elements from the internett.

> **Note:** If your app targets Android 5.0 (API level 21) or later, use the `JobScheduler` class to schedule actions. JobScheduler has the advantage of conserving battery by optimally scheduling jobs to reduce power consumption, and by working with the [Doze](https://developer.android.com/training/monitoring-device-state/doze-standby.html) API. For more information about using this class, see the `JobScheduler` reference documentation. https://developer.android.com/guide/components/fundamentals?hl=en

### Broadcast Reciver

Can transmit events to all apps on the system, even if the app isen't running. Events could be that some resource is downloaded and ready for the app to be used. Or indicate that something has happend. Eg. Message recived ?!

> A broadcast receiver is implemented as a subclass of `BroadcastReceiver` and each broadcast is delivered as an `Intent` object. For more information, see the `BroadcastReceiver` class.

### Content Provider

Handels all kinds of presistence of data. This could be at local storage, SQLlite on the web or even the clipboard. These resources could be shared or protected from other apps. 

> A content provider is implemented as a subclass of `ContentProvider` and must implement a standard set of APIs that enable other apps to perform transactions.



TODO: 

- [ ] Callback explained
- [ ] DataBinding i detail view



