package com.example.apiclient.service;

import com.example.apiclient.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ApiClientService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String POSTS_ENDPOINT = BASE_URL + "/posts";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void performApiAnalysis() {
        System.out.println("--- Task 2: Retrieve All Posts ---");
        retrieveAllPosts();

        System.out.println("\n--- Task 3: Retrieve a Single Post by ID (id=7) ---");
        retrieveSinglePost(7);
    }

    private void retrieveAllPosts() {
        // TODO: Implement Step 2: Retrieve All Posts
        //  1. Make an HTTP GET request to `https://jsonplaceholder.typicode.com/posts`.
        //     Use `restTemplate.getForEntity()` to get the response.
        //  2. Print the HTTP status code of the response.
        //  3. Get the JSON response body as a String and print it.
        //  4. Parse the JSON response body into a `List<Post>` using `objectMapper`.
        //     (Hint: Use `new TypeReference<List<Post>>() {}` for generic types).
        //     Identify and print what kind of data structure it is.
        //  5. From the parsed list, identify the `id` and `title` of the *first five* posts and print them.
        //  6. (Optional) Inspect and print at least two interesting HTTP headers (e.g., `Content-Type`, `Server`).

    }

    private void retrieveSinglePost(int postId) {
        // TODO: Implement Step 3: Retrieve a Single Post by ID
        //  1. Construct the URL for a single post (e.g., `https://jsonplaceholder.typicode.com/posts/7`).
        //  2. Make an HTTP GET request to this URL using `restTemplate.getForEntity()`.
        //  3. Print the HTTP status code of the response.
        //  4. Get the JSON response body as a String and print it.
        //  5. Parse the JSON response body into a `Post` object using `objectMapper`.
        //     Identify and print how its structure differs from the response for all posts.
        //  6. From the parsed `Post` object, extract and print the `userId`, `id`, `title`, and `body`.
        //  7. (Optional) Inspect and print at least two interesting HTTP headers (e.g., `Content-Type`, `Date`).

    }
}