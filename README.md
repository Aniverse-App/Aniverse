Original App Design Project - README Template
===

# Aniverse

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
[This app populates a list of Anime, Manga, and Characters which includes all the information about them. The ability to open a discussion about an anime the user is watching, the manga they are reading, or a character they are interested in. This app also allows the user to view the anime or read the manga within the app.]

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category: Entertainement**
- **Mobile: Mobile is view only. A list of anime/manga is populated on the screen. The user can click on the anime/manga and if they want to watch a button will be there for them to click on and watch the anime or read the manga in their web browser.**
- **Story: Allows users to not only watch their favorite anime and read their favorite manga but watch new Anime and read new Manga that could become their favorite.**
- **Market: Anyone who is a fan of anime and wants to watch it in their spare time or read about it in the Manga. This app is also for people new to the anime community and who want to learn more about it.**
- **Habit: Users can watch anime or read the manga whenever they want and they could encourage their friends to also watch anime or read the manga with them encouraging an anime following.**
- **Scope: The Aniverse app has a narrow focus just listing the anime/manga from the newest to oldest and the user can watch/read whatever anime/manga catches their eye.**

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**
* [User can view a list of anime/manga/characters]
* [User must be able to search for the anime/manga/character that interests them]
* [There must be a navigation bar that organizes the data into various screens]
* [User can Log In and Sign Up]
* [User can save/unsave their favorite anime/manga.]
    * [The saved anime/manga will appear in the user's profile.] 
* [When clicking on the anime/manga details of it should appear in another tab.]
* [User must be able to watch the Anime within the app.] 
* [User must be able to read the Manga within the app.]
* [User must be able to learn about a Character within the app.]
* [User must be able to open a discussion on the anime they are watching, the manga they are reading, or a character they like/dislike.]
* [Allow the logged in user to add a profile photo] 
* [Display the profile photo with each post] 
* [Tapping on a post's username or profile photo goes to that user's profile page and shows a grid view of the user's posts]

**Optional Nice-to-have Stories**
* [User will be able to leave a review of the anime they watched.]
* [User will be able to leave a review of the manga they read.]
* [User can give a rating to the anime/manga out of 5 Stars]
* [Anime/Manga will be categorized for the results to be filtered]
* [For new users a screen shows up asking the user for the category if anime/manga they are into and the list will be populated with those types of anime/manga]

### 2. Screen Archetypes

* [Login/Sign Up Screen]
   * [User can Log In or Create a new Account]
* [Anime List]
   * [User can view a list of anime]
* [Anime Details Screen]
    * [When clicking on the Anime a more detailed view of the Anime will appear along with the option to watch the anime]
* [Manga List]
   * [User can view a list of manga]
* [Manga Details Screen]
    * [When clicking on the Manga a more detailed view of the Manga will appear along with the option to read the manga]
* [Character List]
   * [User can view a list of characters]
* [Character Details Screen]
    * [When clicking on the Character a more detailed view of the Character will appear with all the information about this character]
* [Search]
   * [User can search for an anime/manga/character]
* [Discussion Screen]
    * [User can start a discussion about an anime they are watching or a manga they are reading or a character they like/dislike]
* [Profile Screen]
    * [User can view the anime/manga they favorited in their screen along with any comments they have made and discusssions they have started]

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* [Anime List]
* [Manga List]
* [Character List]
* [Search]
* [Discussion]
* [Profile]

**Flow Navigation** (Screen to Screen)

* [Log In/Sign Up Screen]
   * [Home]
* [Anime Screen]
    * [A list of Anime]
* [Anime Data Screen]
    * [The information about a particular anime alongside the ability to watch it in the app]
* [Manga Screen] 
    * [A list of Manga]
* [Manga Data Screen]
    * [The information about a particular manga and the ability to read it]
* [Character Screen] 
    * [A list of Characters]
* [Character Data Screen]
    * [The information about a particular character with all the information about them.]
* [Search Screen]
    * [A search bar where the user can find an Anime or Manga]
* [Discussion]
    * [A list of discussion about an anime or manga a user watched]
* [Profile Screen]
    * [Information about the user. Their favorited anime/manga, comments they've posted, and discussions they have started]

## Wireframes:

<img src="https://i.imgur.com/IGR2tof.jpg" width=600>
 
### [BONUS] Digital Wireframes & Mockups:
<img src="https://i.imgur.com/AMIUTBc.png"
width=600>

### [BONUS] Interactive Prototype:
<img src="https://i.imgur.com/kGcbBrT.gif"
width=600>

## Schema 
### Models
Model: Login Screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  Username  | String|  Gets the username of the account.   |
|   Password   |      String     | Gets the Username of the account |

Model: Anime screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  Anime name   | String |          Gets the title of the anime          |
|   Anime picture   |      File       | Gets the picture of the anime |

Model: Anime Details Screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  Title   | String|  Gets the Title of anime |
|   Anime description  |      String     | Description of what the anime is about |
|  Reviews | String|  A comment posted by a user on the Anime.      |
|   Episodes |      Int    | A list of episodes |
|  Video| N/A| A list of Promotional Videos & episodes |
|   Date aired| DateTime | Tell the user when the anime aired if it is still going or ended at a certain date |

Model: Manga Screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  Manga name   | String |          Gets the title of the manga          |
|   Manga picture   |      File       | Gets the picture of the manga |

Model: Manga Details Screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  Title   | String|  Gets the title of the manga |
|   Manga description   |      String     | Description of what the manga is about. |
|  Reviews | String|  A comment posted by a user on the Manga     |
|   Date Published| DateTime | Tell the user when the manga was published|

Model: Discussion Screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  UserId   | Pointer to user |          Unique id for the user           |
|  UserImage   | File |          Profile Image for the user           |
|   Image   |      File       | If users want to add images to their post |
|   Text    |     String      |  If users want to add text to their post  |
| CreatedAt |    DateTime     |         Date when post is created         |
|UpdatedAt| DateTime| Date for when the post was updated|
|Like Counter| Number| How many likes a post has|

Model: Search Screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  Searchbar | String| Specify what to search. The title of an anime/manga.   |

Model: Profile Screen
| Property  |      Type       |                Description                |
|:---------:|:---------------:|:-----------------------------------------:|
|  Image   | File |  Shows the user’s profile picture         |
|   Comments   |      String     | The list of discussions started by the user |
|  Discussions  | String|  The list of discussions started by the user      |
|   Favorites  |      String     | The list of favorites in a list |

### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
