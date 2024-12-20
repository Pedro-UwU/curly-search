<p align="center">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="center" width="30%">
</p>
<p align="center"><h1 align="center">CURLY-SEARCH</h1></p>
<p align="center">
	<em>Unleashing Precision in Every Search Operation!</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/Pedro-UwU/curly-search?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/Pedro-UwU/curly-search?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/Pedro-UwU/curly-search?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/Pedro-UwU/curly-search?style=default&color=0080ff" alt="repo-language-count">
</p>
<p align="center"><!-- default option, no dependency badges. -->
</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>
<br>

## 🔗 Table of Contents

- [📍 Overview](#-overview)
- [👾 Features](#-features)
- [📁 Project Structure](#-project-structure)
  - [📂 Project Index](#-project-index)
- [🚀 Getting Started](#-getting-started)
  - [☑️ Prerequisites](#-prerequisites)
  - [⚙️ Installation](#-installation)
  - [🤖 Usage](#🤖-usage)
  - [🧪 Testing](#🧪-testing)
- [📌 Project Roadmap](#-project-roadmap)
- [🔰 Contributing](#-contributing)
- [🎗 License](#-license)
- [🙌 Acknowledgments](#-acknowledgments)

---

## 📍 Overview

Curly-search is an innovative open-source project designed to streamline text analysis and processing. Leveraging the power of the Bitap algorithm, it offers precise string matching capabilities, even allowing for a defined number of errors. With its unique keyword-based scoring system, users can define rulesets for text evaluation, making it an invaluable tool for data scientists, developers, and researchers. Curly-search simplifies complex text analysis, delivering accurate results and enhancing decision-making processes.

---

## 👾 Features

|      | Feature         | Summary       |
| :--- | :---:           | :---          |
| ⚙️  | **Architecture**  | <ul><li>Uses a modular architecture with separate classes for `Rule`, `RuleSet`, and `Evaluation`.</li><li>Employs the Bitap algorithm for string matching operations.</li><li>Utilizes a keyword-based scoring system defined in `ruleSet.yaml` and `ruleSet.json`.</li></ul> |
| 🔩 | **Code Quality**  | <ul><li>Code is written in `Kotlin`, ensuring type-safety and null-safety.</li><li>Follows good practices such as separation of concerns and encapsulation.</li><li>Test suites like `RuleSetTest.kt` and `BitapSearchTest.kt` ensure code reliability.</li></ul> |
| 📄 | **Documentation** | <ul><li>Primary language used is `Kotlin`.</li><li>Usage, installation, and test commands are well-documented.</li><li>Each file and its purpose are clearly described.</li></ul> |
| 🔌 | **Integrations**  | <ul><li>Integrates `Jackson` for JSON processing.</li><li>Uses `Gradle` for build automation and dependency management.</li><li>Applies the `org.gradle.toolchains.foojay-resolver-convention` plugin for Java toolchain resolution.</li></ul> |
| 🧩 | **Modularity**    | <ul><li>Code is organized into separate modules for different functionalities.</li><li>Classes like `Rule`, `RuleSet`, and `Evaluation` ensure modularity.</li><li>Test resources are separated from main resources.</li></ul> |
| 🧪 | **Testing**       | <ul><li>Uses `Gradle` for running tests.</li><li>Includes test suites like `RuleSetTest.kt` and `BitapSearchTest.kt`.</li><li>Tests cover both perfect and fuzzy matches, as well as negative scenarios.</li></ul> |
| ⚡️  | **Performance**   | <ul><li>Employs the Bitap algorithm for efficient string matching.</li><li>Uses `Gradle` for efficient build automation.</li><li>Keyword-based scoring system ensures efficient evaluation of text inputs.</li></ul> |
| 🛡️ | **Security**      | <ul><li>Uses `Gradle` which has built-in security features.</li><li>Code is written in `Kotlin`, which is statically typed and null-safe, reducing potential bugs and vulnerabilities.</li><li>No explicit security measures mentioned in the provided context.</li></ul> |
| 📦 | **Dependencies**  | <ul><li>Uses `Gradle` for dependency management.</li><li>Dependencies include `Kotlin`, `Jackson`, and `Gradle` among others.</li><li>Dependencies are specified in `build.gradle.kts`.</li></ul> |

---

## 📁 Project Structure

```sh
└── curly-search/
    ├── LICENSE
    ├── README.md
    ├── build.gradle
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle.kts
    └── src
        ├── main
        └── test
```


### 📂 Project Index
<details open>
	<summary><b><code>CURLY-SEARCH/</code></b></summary>
	<details> <!-- __root__ Submodule -->
		<summary><b>__root__</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td>- Build.gradle.kts configures the project's build system, specifying dependencies, plugins, and publishing details<br>- It sets up the Kotlin and Java libraries, integrates Jackson for JSON processing, and configures Maven for publishing<br>- It also includes test configurations and JVM toolchain settings, ensuring a comprehensive build environment.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
				<td>- Gradlew.bat serves as a Gradle startup script for Windows within the project<br>- It primarily manages the initialization and execution of Gradle tasks, ensuring the correct Java environment is set up<br>- The script also handles error scenarios related to Java installation, providing a robust foundation for the project's build automation.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/settings.gradle.kts'>settings.gradle.kts</a></b></td>
				<td>- Settings.gradle.kts configures the root project name as "curly-search" and applies the "org.gradle.toolchains.foojay-resolver-convention" plugin<br>- This plugin aids in resolving Java toolchains, ensuring the project uses the correct Java version<br>- The file plays a crucial role in the overall project setup and configuration.</td>
			</tr>
			</table>
		</blockquote>
	</details>
	<details> <!-- src Submodule -->
		<summary><b>src</b></summary>
		<blockquote>
			<details>
				<summary><b>test</b></summary>
				<blockquote>
					<details>
						<summary><b>resources</b></summary>
						<blockquote>
							<table>
							<tr>
								<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/test/resources/ruleSet.yaml'>ruleSet.yaml</a></b></td>
								<td>- The 'ruleSet.yaml' file in the 'src/test/resources' directory defines a set of rules for a keyword-based scoring system<br>- It specifies keywords, their maximum distance, and their weight for a test scenario<br>- This contributes to the project's functionality by enabling keyword-based analysis and scoring, thereby influencing the overall decision-making process.</td>
							</tr>
							<tr>
								<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/test/resources/ruleSet.json'>ruleSet.json</a></b></td>
								<td>- RuleSet.json, located in the test resources, defines a set of rules for a test scenario<br>- It specifies keywords, their maximum distance, and weight for a threshold-based system<br>- This configuration aids in the evaluation of text inputs, contributing to the overall functionality of the project's text analysis and processing.</td>
							</tr>
							</table>
						</blockquote>
					</details>
					<details>
						<summary><b>kotlin</b></summary>
						<blockquote>
							<table>
							<tr>
								<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/test/kotlin/RuleSetTest.kt'>RuleSetTest.kt</a></b></td>
								<td>- RuleSetTest.kt is a test suite for the RuleSet class, ensuring its correct functionality<br>- It verifies the ability to read RuleSets from JSON and YAML files, evaluates the RuleSet against perfect, fuzzy, and negative matches, and tests RuleSet evaluation against a list of strings.</td>
							</tr>
							<tr>
								<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/test/kotlin/BitapSearchTest.kt'>BitapSearchTest.kt</a></b></td>
								<td>- BitapSearchTest.kt, located in the test directory, validates the functionality of the BitapSearch algorithm<br>- It ensures accurate results for exact and fuzzy matches within a given string, and verifies the handling of non-matching scenarios<br>- This contributes to the robustness and reliability of the overall codebase.</td>
							</tr>
							</table>
						</blockquote>
					</details>
				</blockquote>
			</details>
			<details>
				<summary><b>main</b></summary>
				<blockquote>
					<details>
						<summary><b>kotlin</b></summary>
						<blockquote>
							<table>
							<tr>
								<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/main/kotlin/BitapSearch.kt'>BitapSearch.kt</a></b></td>
								<td>- BitapSearch in the Kotlin source code is a utility class that facilitates string matching operations<br>- It employs the Bitap algorithm to search for a specific string (needle) within a larger string (haystack), allowing for a defined number of errors<br>- The function returns the located string and the number of errors encountered during the search.</td>
							</tr>
							</table>
							<details>
								<summary><b>models</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/main/kotlin/models/Evaluation.kt'>Evaluation.kt</a></b></td>
										<td>- Evaluation.kt, located in the models directory, defines a data class for evaluating rule sets<br>- It encapsulates the rule set, a score, and a success status<br>- This class plays a crucial role in the project's architecture by providing a structured way to assess the effectiveness of different rule sets.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/main/kotlin/models/RuleSet.kt'>RuleSet.kt</a></b></td>
										<td>- RuleSet.kt, located in the models directory, is a Kotlin class that manages a set of rules<br>- It provides functionality to load rule sets from JSON or YAML files or strings, evaluate text or a list of strings against these rules, and return an evaluation score<br>- This score indicates whether the evaluated content meets the defined threshold, thus determining its compliance with the rule set.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/Pedro-UwU/curly-search/blob/master/src/main/kotlin/models/Rule.kt'>Rule.kt</a></b></td>
										<td>- Rule.kt, located in the models directory, defines a data class in Kotlin for managing rule objects<br>- These objects contain a keyword, a maximum distance, and a weight<br>- This class is crucial for handling rules within the application, particularly for operations involving keyword distance calculations and weight assignments.</td>
									</tr>
									</table>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---
## 🚀 Getting Started

### ☑️ Prerequisites

Before getting started with curly-search, ensure your runtime environment meets the following requirements:

- **Programming Language:** Kotlin
- **Package Manager:** Gradle


### ⚙️ Installation

Install curly-search using one of the following methods:

**Build from source:**

1. Clone the curly-search repository:
```sh
❯ git clone https://github.com/Pedro-UwU/curly-search
```

2. Navigate to the project directory:
```sh
❯ cd curly-search
```

3. Install the project dependencies:


**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle build
```




### 🤖 Usage
Run curly-search using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle run
```


### 🧪 Testing
Run the test suite using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle test
```


---
## 📌 Project Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

---

## 🔰 Contributing

- **💬 [Join the Discussions](https://github.com/Pedro-UwU/curly-search/discussions)**: Share your insights, provide feedback, or ask questions.
- **🐛 [Report Issues](https://github.com/Pedro-UwU/curly-search/issues)**: Submit bugs found or log feature requests for the `curly-search` project.
- **💡 [Submit Pull Requests](https://github.com/Pedro-UwU/curly-search/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/Pedro-UwU/curly-search
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/Pedro-UwU/curly-search/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=Pedro-UwU/curly-search">
   </a>
</p>
</details>

---

## 🎗 License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

## 🙌 Acknowledgments

- List any resources, contributors, inspiration, etc. here.

---
