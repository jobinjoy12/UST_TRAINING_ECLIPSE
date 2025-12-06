import java.io.Closeable;

class ResourceInitializationException extends Exception {
	public ResourceInitializationException(String message) { super(message); }
}

class ResourceProcessingException extends Exception {
	public ResourceProcessingException(String message) { super(message); }
}

class CustomResource implements AutoCloseable {
	private String name;
	private boolean initialized = false;

	public CustomResource(String name, boolean failInitialization) throws ResourceInitializationException {
		this.name = name;
		System.out.println("Attempting to initialize CustomResource: " + name);
		if (failInitialization) {
			throw new ResourceInitializationException("Failed to initialize resource: " + name);
		}
		initialized = true;
		System.out.println("CustomResource initialized: " + name);
	}

	public void process(boolean failProcessing) throws ResourceProcessingException {
		if (!initialized) {
			throw new IllegalStateException("Resource " + name + " not initialized.");
		}
		System.out.println("Processing CustomResource: " + name);
		if (failProcessing) {
			throw new ResourceProcessingException("Failed to process resource: " + name);
		}
		System.out.println("CustomResource processing complete: " + name);
	}

	@Override
	public void close() {
		System.out.println("Closing CustomResource: " + name);
	}
}

class ResourceManager {
	public void manageResource(String resourceName, boolean failInit, boolean failProcess) {
		try (CustomResource resource= new CustomResource(resourceName, failInit)){
            resource.process(failProcess);
        } catch (ResourceInitializationException e) {System.out.println(e.getMessage());}
        catch(ResourceProcessingException e){System.out.println(e.getMessage());}
        }
        }
        
        // Your code here: Use CustomResource within a try-with-resources block
		// Handle ResourceInitializationException and ResourceProcessingException
		// Print appropriate messages for success, init failure, process failure, and closing
	
