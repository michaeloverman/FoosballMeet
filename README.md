# ANDROID CODE CHALLENGE
## The App: Foosball Matches
At TMG, we love foosball. Most arguments over who is the best are settled on the table, but nobody can remember the scores from weeks ago. We need a way to track the results and for everyone to see who is the current king. Please create a simple application that tracks foosball ratings. You should be able to input historical results, update results, and retrieve current rankings. Below are some sample historical cores to get you started.

## Data structure
Person,Score,Person,Score
Amos,4,Diego,5
Amos,1,Diego,5
Amos,2,Diego,5
Amos,0,Diego,5
Amos,6,Diego,5
Amos,5,Diego,2
Amos,4,Diego,0
Joel,4,Diego,5
Tim,4,Amos,5
Tim,5,Amos,2
Amos,3,Tim,5
Amos,5,Tim,3
Amos,5,Joel,4
Joel,5,Tim,2

## Notes
Implement a rankings view which lists users in order of their ranking (by number of games played, games won).

The implementation should include the use of Fragments, dependency injection, and a consistent software architectural pattern. At TMG, we extensively use Dagger, MVVM using Jetpack, and RxJava2, and strongly recommend demonstrating them in the solution. The solution should demonstrate an understanding of the thread handling, reactive patterns, the Android lifecycle, and communication between UI components including Activities, and Fragments.

A robust data store is not required, so an in-memory collection may be used instead of a server api or a database implementation. Please add a brief comment in the code explaining the boundary where a real store may be used instead.

# Process
Short notes about the decision process in getting this up and running

## Assumptions
There will always be a winner and a loser, no ties

## Data
My first big decision was how to manage/store/manipulate/understand the data itself. My initial thought was to use a database anyway, and just store each game result in a table. Then SQL commands could parse, structure and rearrange that data as needed. This still might ultimately be the way to go for this, long term. But in the end I decided that storing each person's results within themselves would be easier, and eliminate the need to set up the whole database infrastructure, and also not require a two day review of SQL in order to get what I need.

## Rejections
Compose: I decided not to use this mostly because Bryan told me TMG is not using Compose. But it was also good to 'remember' how to create an activity/fragment structure from the bottom up, something I've not done in over a year.
