graph TB
    subgraph Input["Input Layer"]
        A1[Snyk Results JSON] --> B
        A2[Original pom.xml] --> B
        A3[Environment Variables] --> B
    end

    subgraph MainController["Main Controller"]
        B[Python Automation Script] --> C1
        B --> C2
        B --> C3
    end

    subgraph Processing["Processing Layer"]
        C1[Vulnerability Parser]
        C2[File Management] 
        C3[Logger/Metrics]
    end

    subgraph AIRemediation["AI Remediation Layer"]
        D1[Mistral AI API] --> D2[Fix Generator]
        D2 --> D3[Version Validator]
        D3 --> D4[POM Processor]
    end

    subgraph ValidationLayer["Validation Layer"]
        E1[Maven Build] --> E2[Spring Boot Test]
        E2 --> E3[Retry Logic]
        E3 -->|Success| E4[Success Handler]
        E3 -->|Failure| E1
    end

    subgraph GitHubIntegration["GitHub Integration"]
        F1[Branch Creation] --> F2[File Operations]
        F2 --> F3[PR Generation]
        F3 --> F4[Summary Reports]
    end

    C1 --> D1
    C2 --> D4
    D4 --> E1
    E4 --> F1
