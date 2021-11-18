package com.example.project3frontend;

/**
 * The type <Project> list view model.
 */

public class ProjectListViewModel {


    private String title;
    private Integer id;
    private String description;
    private String image;


    /**
     * Instantiates a new Pet list view model.
     *
     * @param id     the id
     * @param title   the title
     * @param description   the description
     * @param image the image
     */
    public ProjectListViewModel(Integer id, String title, String description, String image) {


        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }


}