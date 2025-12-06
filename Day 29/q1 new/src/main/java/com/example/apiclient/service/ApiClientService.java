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

    public void retrieveAllPosts() {

        ResponseEntity<String> entity = restTemplate.getForEntity(POSTS_ENDPOINT, String.class);

        System.out.println("Status: " + entity.getStatusCode());

        String json = entity.getBody();
        System.out.println("Raw JSON: " + json);

        try {
            List<Post> postList = objectMapper.readValue(json, new TypeReference<List<Post>>() {});
            System.out.println("Parsed into List<Post>, size = " + postList.size());

            for (int i = 0; i < 5; i++) {
                System.out.println("ID: " + postList.get(i).getId());
                System.out.println("Title: " + postList.get(i).getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Headers: " + entity.getHeaders());
    }

    public void retrieveSinglePost(int postId) {
        // Use getForEntity to capture status + headers + body
        ResponseEntity<String> entity = restTemplate.getForEntity(POSTS_ENDPOINT + "/" + postId, String.class);

    
        System.out.println("Status: " + entity.getStatusCode());


        String json = entity.getBody();
        System.out.println("Raw JSON: " + json);

       //Parse JSON into Post object
        try {
            Post post = objectMapper.readValue(json, Post.class);
            System.out.println("Parsed Post: " + post);

            // Extract fields
            System.out.println("userId: " + post.getUserId());
            System.out.println("id: " + post.getId());
            System.out.println("title: " + post.getTitle());
            System.out.println("body: " + post.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print interesting headers
        System.out.println("Content-Type: " + entity.getHeaders().getContentType());
    System.out.println("Date: " + entity.getHeaders().getFirst("Date"));

    }
}