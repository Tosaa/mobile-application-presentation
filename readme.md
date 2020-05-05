# Presentation Mobile Development
## requirement
Every student has to do a presentation on a mobile-related topic. The presentations are done in pairs. The list of presentations with dates is below.

Your presentation:

duration 25 minutes (per 2 students); if the presentation time is clearly exceeded or too short, your presentation grade will be marked down.  
Your presentation should include the following components:  
* Motivation and introduction to the topic
* Technical background
* Implementation/application on a mobile platform
* Short demonstration (live programming or similar)
* Summary


We might not need a report but just presentation notes that can be handed out to all students of the class.  
You will **not** be graded based on the **complexity** of the code you present.  You will be graded on how **well** you **present** the code and on how **understandable** your presentation/webinar is. It is absolutely fine, to use very **simple code** and explain it well. Code is difficult to understand, especially if it is not your own code. You decide **whether live coding is appropriate or not.** If it does not fit well in your talk, don't worry. Then don't do it. However, I want your presentation to be a **tech talk** and not a **high-level overview.**

Preliminary discussion of the presentations with the instructor (voluntary): 1-2 weeks before the presentation, please send the status of your **slides by Wednesday, 6 pm at the latest.** The discussion is then during lab time on Friday. 

## Plan:

#### what to show ?
- what is live-data (2 min)
- compare live-data with observable pattern (3 min)
- how to import live-data (3 min)
  - show the gradle import which needs to be done
  - import in your file
  - subscribe any provided live-data
- how to use live-data? (2 - 3 min)
  - observe provided live-data
  - provide live-data to others (from database / static list / api)
- transform live-data (1 min)
- hints / tricks (5 min - or just for handout)
  - pass an lifecycle !
  - use live-data directly in xml
  - make sure live-data is observed -> else : live-data.value will be empty/default
  - live-data variations (mutablelivedata, mediatorlivedata, ...)
  - combining different live-data
  
## idea:
create an app which shows a list of t-shirts. 
t-shirt:
- color
- id
- size
the app can show all t shirts (1 Page)  
shows some icons in a color with a t-shirt displayed on it.

the app can show one t shirt and its information (2 Page)  
show big t shirt icon
show t shirt size (read size in xml to show no need to unpack LiveData objects)  
show t shirt color (use color variable in t-shirt) 
switch to next or previous t-shirt (by select index)
maybe hide previous or next button if index is at 0 or list.length-1

shared ViewModel:
- list of t-shirts (array/list/livedata<list>)
- selected index of list (MutableLiveData<Int>)
- selected t-shirt (observation of selectedIndex, which takes tshirt in list at index)
- color of selected t-shirt (Transformation of selected t-shirt)
  

