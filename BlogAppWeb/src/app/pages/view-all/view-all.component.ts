import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.scss']
})
export class ViewAllComponent {

  allPosts:any;

  constructor(private postService: PostService, private snackBar: MatSnackBar){}

  ngOnInit() {
    this.getAllPosts();
  }

  getAllPosts() {
    this.postService.getAllPosts().subscribe(res => {
      this.allPosts = res;
      
      if(this.allPosts.length == 0) {
        this.snackBar.open("There is no posts now!", "OK");
      }
    }, error => {
      this.snackBar.open("Something went wrong !", "OK");
    });

  }

}
