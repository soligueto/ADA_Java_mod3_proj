package tech.ada.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Tutorial {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "title")
  private String nome;

  @Column(name = "age")
  private String age;

  @Column(name = "published")
  private boolean published;

  public Tutorial() {

  }

  public Tutorial(String title, String description, boolean published) {
    this.nome = title;
    this.age = description;
    this.published = published;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return nome;
  }

  public void setTitle(String title) {
    this.nome = title;
  }

  public String getDescription() {
    return age;
  }

  public void setDescription(String description) {
    this.age = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + nome + ", desc=" + age + ", published=" + published + "]";
  }

}
