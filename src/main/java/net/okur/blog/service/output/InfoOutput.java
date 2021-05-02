package net.okur.blog.service.output;

import lombok.Data;

@Data
public class InfoOutput {
  private InfoStatus infoStatus;
  private String infoMessage;

  public enum InfoStatus {
    ERROR, SUCCESS
  }
}
