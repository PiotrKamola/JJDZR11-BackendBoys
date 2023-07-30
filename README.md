[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]




<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/infoshareacademy/JJDZR11-BackendBoys">
    <img src="web/src/main/resources/static/img/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">ZgubaApp</h3>

  <p align="center">
    Find your missing item!
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

ZgubaApp is a platform that helps you find lost items or find the owner of found items. 
Our mission is to facilitate the process of recovering lost items and returning them to their rightful owners. 
Join our community and help us create a world where no lost items are left without an owner.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Java][Java]][Java-url]
* [![Spring][Spring]][Spring-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get started you need to follow instructions below.

### Prerequisites

* clone project repository
    ```sh
    git clone git@github.com:infoshareacademy/JJDZR11-BackendBoys.git
    ```
  
* create docker
    ```sh
    docker run -p 0.0.0.0:3307:3306 --name zgubaDatabase -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=zgubaDatabase -d mysql:8.0.32
    ```
  
* run docker
    ```sh
    docker start zgubaDatabase
    ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

User Registration:
John, a park enthusiast, heard about ZgubaApp from a friend. He decides to registers as a new user by providing his email and creating a password.

Reporting a Lost Item:
One day, while John is at the local park, he realizes that he lost his favorite sunglasses. He quickly opens the ZgubaApp and clicks on the "Dodaj zgubę" button.

Item Details:
John fills in the details of the lost item, including a description of the sunglasses, the location where he last had them (the park), and the date when he noticed them missing.

Submission:
After completing the form, John clicks the "Wyślij zgłoszenie" button, and the app registers his lost item report in the database.

User Interaction:
Sarah, another user of ZgubaApp, recalls seeing a pair of sunglasses matching the description in the park earlier that day. She decides to check if they are still there.

Notifying the Owner:
Sarah contact with John via his email.

Reuniting the Owner with the Lost Item:
John receives the email and contacts Sarah. They agree to meet at the park, and Sarah happily returns the sunglasses to John.

Community Success:
John expresses his gratitude to Sarah, and both users feel a sense of fulfillment in being part of a community that helps reunite lost items with their rightful owners.

App Engagement:
John continues to use ZgubaApp regularly to report lost items he finds and to help others in the community recover their belongings.
ZgubaApp's platform successfully facilitated the process of finding and returning lost items, creating a supportive community dedicated to reuniting lost possessions with their owners.



<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See LICENSE.txt for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Tomasz Płoński - [@your_twitter](https://twitter.com/your_username) - email@example.com

Piotr Kamola - p.kamola98@wp.pl

Aleksander Kulej - [@AleksanderKulej](https://twitter.com/AleksanderKulej)


Project Link: (https://github.com/infoshareacademy/JJDZR11-BackendBoys)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Thanks to the creators and developers. And also to infoShareAcademy for all the support.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
  [contributors-shield]: https://img.shields.io/badge/CONTRIBUTORS-8A2BE2
[contributors-url]: https://github.com/infoshareacademy/JJDZR11-BackendBoys/graphs/contributors
[forks-shield]: https://img.shields.io/badge/FORKS-green
[forks-url]: https://github.com/infoshareacademy/JJDZR11-BackendBoys/forks
[stars-shield]: https://img.shields.io/badge/STARS-yellow
[stars-url]: https://github.com/infoshareacademy/JJDZR11-BackendBoys/stargazers
[issues-shield]: https://img.shields.io/badge/ISSUES-red
[issues-url]: https://github.com/infoshareacademy/JJDZR11-BackendBoys/issues
[license-shield]: https://img.shields.io/badge/LICENSE-orange
[license-url]: https://github.com/infoshareacademy/JJDZR11-BackendBoys/blob/main/LICENSE
[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/java-blue?Java=java
[Java-url]: https://www.java.com/pl/
[Spring]: https://img.shields.io/badge/spring-blue?Spring=spring
[Spring-url]: https://spring.io/projects/spring-boot
